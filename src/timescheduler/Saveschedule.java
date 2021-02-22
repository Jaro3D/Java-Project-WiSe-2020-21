/**
 * Create by Ahmed Noorzi, 1312933
 * Java WiSe 2020/21 Project
 * 
 */

package timescheduler;

import java.awt.Dimension;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.font.PDFont;
import be.quodlibet.boxable.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Saveschedule {
    /**
     * This is the main method that operates the saving of the schedule. 
     * Within the method a new File object is created that calls the 
     * getSelectedFileExtension function which returns a File object with the 
     * chosen file extension by the user.
     * Next, a list of the events is created by calling the 
     * loadUserEventsThisWeek function from the Database class.
     * Finally, depending on the extension either a text file or a PDF is 
     * created and will be saved. 
     */
    public void saveschedule(int currentUserID){
        JFileChooser fs = new JFileChooser(new File("c:\\"));
        fs.setDialogTitle("Save schedule as");
        
        //only pdf and txt are option not *all files
        fs.setAcceptAllFileFilterUsed(false);
        fs.addChoosableFileFilter(new FileNameExtensionFilter("*.pdf", "pdf"));
        fs.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
        
        
        int result = fs.showSaveDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION){
            File fi = getSelectedFileWithExtension(fs);
            
            
            String name = fi.getName();
            
            //creates index counting from . in filename
            int lastIndexOf = name.lastIndexOf(".");
            //returns the substring starting from the specified index
            String extension = name.substring(lastIndexOf);
            
            Event[] content = Database.loadUserEventsThisWeek(currentUserID);
            
            //open txt file and add content
            if(extension.equals(".txt")){ 
                BufferedWriter out = null;
                try {
                    
                    File textfile = new File(fi.getPath());
                    out = new BufferedWriter(new FileWriter(textfile,false));
                    out.flush();
                    
                    out.write("+------+-------+---------------------------+---------------------------------------+------------------------------+------------+--------------+----------+--------------+\n");
                    out.write("|  ID  | Owner |           Title           |                Address                |             Date             |  Duration  | Notification | Priority | Participants |\n");
                    
                    
                    List format = new ArrayList();
                    format.add("%-4s"); format.add("%-5s");
                    format.add("%-25s"); format.add("%-37s");
                    format.add("%-28s"); format.add("%-10s");
                    format.add("%-12s"); format.add("%-8s");
                    format.add("%-12s"); format.add("%-12s");
                    
                    SimpleDateFormat simpleformat = new SimpleDateFormat("EEE dd MMM yyyy HH:mm:ss");
                    for(int i=0; i<content.length;i++){
                        out.write("+------+-------+---------------------------+---------------------------------------+------------------------------+------------+--------------+----------+--------------+\n");
                            out.write("| "+String.format((String)format.get(0),content[i].getId())+" | "+String.format((String)format.get(1),content[i].getOwnerID())+" | "+
                                    String.format((String)format.get(2),content[i].getTitle())+" | "+String.format((String)format.get(3),content[i].getAddress()[0]+ " "+content[i].getAddress()[1])+" | "+
                                    String.format((String)format.get(4),simpleformat.format(content[i].getDate()))+" | "+String.format((String)format.get(5),content[i].getDuration())+" | "+
                                    String.format((String)format.get(6),content[i].getNotification())+" | "+String.format((String)format.get(7),+content[i].getPriority())+" | "+
                                    String.format((String)format.get(8),Arrays.toString(content[i].getParticipantIDs()))+" |\n");
                            
                        
                        out.write("+------+-------+---------------------------+---------------------------------------+------------------------------+------------+--------------+----------+--------------+\n");
                    }
                    out.close();
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    }
            }
            
            //open pdf file and add content
            else if(extension.equals(".pdf")){
                try {  
                    pdftable(fi,content);
                } catch (Exception ex) {
                    Logger.getLogger(Saveschedule.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
   }                             
   
    //http://www.java2s.com/example/java/swing/get-selected-file-with-extension.html
    /**
     * This method is used to return a File object with the valid extension .txt or .pdf
     * @param fs is a JFileChooser instance
     */
    private File getSelectedFileWithExtension(JFileChooser fs){
        //gets selected file from JFileChooser and the file filter from the ExtensionFilter
        File file = fs.getSelectedFile();
        if (fs.getFileFilter() instanceof FileNameExtensionFilter){
            String[] exts = ((FileNameExtensionFilter)fs.getFileFilter()).getExtensions();
            String nameLower = file.getName().toLowerCase();
        
            for(String ext : exts)
            {//checks if it has a valid extension
                if(nameLower.endsWith('.' + ext.toLowerCase())){
                    return file;
                }
            }
            //if not extension from filter is appended
            file = new File(file.toString() + '.' + exts[0]);
        }
        return file;
    }
    
    /**
     * This method creates a table format into the pdf file for the data inside the list of events.
     * @param fi is the File that is created in the saveschedule method
     * @param data is an array that contains the events of the current user 
     */
    public void pdftable(File fi, Event[] data) {
        PDFont fontBold = PDType1Font.HELVETICA_BOLD;
        
        //open pdf file and add content
        PDDocument doc = new PDDocument();    
        PDPage page = new PDPage(new PDRectangle(PDRectangle.A4.getHeight(),PDRectangle.A4.getWidth()));
        
        PDImageXObject pdImage; 
        Dimension scaledDim;
        pdImage =null;
        scaledDim =null;
        
        try {
            
            pdImage = PDImageXObject.createFromFile("src/timescheduler/PDFbgvert.png", doc);
            
            int actualPDFHeight = (int) PDRectangle.A4.getWidth();
            int actualPDFWidth = (int) PDRectangle.A4.getHeight();
            
            scaledDim = getScaledDimension(new Dimension(pdImage.getWidth(), pdImage.getHeight()), new Dimension(actualPDFWidth, actualPDFHeight));
        
        } catch (IOException ex) {
            Logger.getLogger(Saveschedule.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
                    
            doc.addPage(page);
            PDPageContentStream content = new PDPageContentStream(doc, page);
            
            content.drawImage(pdImage, 0, 0, scaledDim.width, scaledDim.height);
            
    //############ Table #######################################################
            float margin = 30;
            float bottomMargin = 30;
        
            // starting yposition is whole page height subtracted by top and bottom margin
            float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
            // we want table across whole page width (subtracted by left and right margin ofcourse)
            float tableWidth = page.getMediaBox().getWidth() - (2 * margin);

            boolean drawContent = true;
        
            // yPosition is the coordinate of top left corner of the table
            float yPosition = 555;

            BaseTable table = new BaseTable(yPosition, yStartNewPage,
                bottomMargin, tableWidth, margin, doc, page, true, drawContent);

            // the parameter is the row height
            Row<PDPage> headerRow = table.createRow(35);
            // the first parameter is the cell width
            Cell<PDPage> cell = headerRow.createCell(5,"ID");
            cell.setFont(fontBold);
            cell.setFontSize(10);
        
            cell = headerRow.createCell(8,"Owner ID");
            cell.setFont(fontBold);
            cell.setFontSize(10);
        
            cell = headerRow.createCell(15,"Title");
            cell.setFont(fontBold);
            cell.setFontSize(10);
        
            cell = headerRow.createCell(26,"Address");
            cell.setFont(fontBold);
            cell.setFontSize(10);
        
            cell = headerRow.createCell(12,"Date");
            cell.setFont(fontBold);
            cell.setFontSize(10);
        
            cell = headerRow.createCell(7,"Duration");
            cell.setFont(fontBold);
            cell.setFontSize(10);
        
            cell = headerRow.createCell(10,"Notification");
            cell.setFont(fontBold);
            cell.setFontSize(10);
        
            cell = headerRow.createCell(7,"Priority");
            cell.setFont(fontBold);
            cell.setFontSize(10);
        
            cell = headerRow.createCell(10,"Participants");
            cell.setFont(fontBold);
            cell.setFontSize(10);
        
        table.addHeaderRow(headerRow);
        
        for(int i=0; i<data.length;i++){
            Row<PDPage> row = table.createRow(20);
                cell = row.createCell(String.valueOf(data[i].getId()));
                cell.setFontSize(10);
                
                cell = row.createCell(String.valueOf(data[i].getOwnerID()));
                cell.setFontSize(10);
                
                cell = row.createCell(data[i].getTitle());
                cell.setFontSize(10);
                
                cell = row.createCell(data[i].getAddress()[0]+ " "+data[i].getAddress()[1]);
                cell.setFontSize(10);
                
                SimpleDateFormat simpleformat = new SimpleDateFormat("EEE dd MMM yyyy HH:mm:ss");
                cell = row.createCell(simpleformat.format(data[i].getDate()));
                cell.setFontSize(10);
                
                cell = row.createCell(data[i].getDuration());
                cell.setFontSize(10);
                
                cell = row.createCell(String.valueOf(data[i].getNotification()));
                cell.setFontSize(10);
                
                switch (data[i].getPriority()) {
                    case 1:
                        cell = row.createCell(String.valueOf(data[i].getPriority()));
                        cell.setFillColor(Color.GREEN);
                        break;
                    case 2:
                        cell = row.createCell(String.valueOf(data[i].getPriority()));
                        cell.setFillColor(Color.YELLOW);
                        break;
                    case 3:
                        cell = row.createCell(String.valueOf(data[i].getPriority()));
                        cell.setFillColor(Color.RED);
                        break;
                    default:
                        cell = row.createCell(String.valueOf(data[i].getPriority()));
                        break;
                } cell.setFontSize(10);
                
                cell = row.createCell(Arrays.toString(data[i].getParticipantIDs()));
                cell.setFontSize(10);
        }

        table.draw();
        
        content.close();
        doc.save(fi.getPath());
        doc.close();
                    
        } catch (IOException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
    
    // https://stackoverflow.com/questions/23223716/scaled-image-blurry-in-pdfbox
    /**
     * This method fixes scaling issues of images that are inserted into PDF files and returns
     * corrected dimesnion values if necessary to fit the images to the file dimensions.
     * @param imgSize contains the width and height of the image
     * @param boundary contains the width and height of the file page(DIN A4)
     * @return fitted width and height
     */
    public static Dimension getScaledDimension(Dimension imgSize, Dimension boundary) {
        int original_width = imgSize.width;
        int original_height = imgSize.height;
        int bound_width = boundary.width;
        int bound_height = boundary.height;
        int new_width = original_width;
        int new_height = original_height;

        // first check if we need to scale width
        if (original_width > bound_width) {
            //scale width to fit
            new_width = bound_width;
            //scale height to maintain aspect ratio
            new_height = (new_width * original_height) / original_width;
        }

        // then check if we need to scale even with the new height
        if (new_height > bound_height) {
        //scale height to fit instead
        new_height = bound_height;
        //scale width to maintain aspect ratio
        new_width = (new_height * original_width) / original_height;
        }

        return new Dimension(new_width, new_height);
    }
}