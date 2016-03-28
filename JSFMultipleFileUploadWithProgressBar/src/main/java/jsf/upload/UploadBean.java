package jsf.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

@Named
@ViewScoped
public class UploadBean implements Serializable {

    @Inject
    @Push(channel = "upload")
    private PushContext push;

    private static final Logger logger = Logger.getLogger(UploadBean.class.getName());
    private List<Part> files;
    private String trash = "{items: []}";

    public void upload(ActionEvent event) {

        if (files != null) {

            int countFiles = 0;
            String trashFiles = trash.substring(trash.indexOf(":"), trash.length() - 1);
            byte maxFilesNumber = Byte.parseByte((String) event.getComponent().getAttributes().get("maxFilesNumber"));
            int maxFileSize = Integer.parseInt((String) event.getComponent().getAttributes().get("maxFileSize"));
            String fileTypes = (String) event.getComponent().getAttributes().get("fileTypes");

            logger.log(Level.INFO, "Files trash:{0}", trash);

            logger.info("Files Details:");

            // compute the files sizes
            long totalSize = 0;
            int totalReadSize = 0;
            for (Part file : files) {
                totalSize += file.getSize();
            }

            for (Part file : files) {

                // validate the file name
                String fileName = file.getSubmittedFileName().trim();
                long filesize = file.getSize();
                if (!fileName.isEmpty()) {

                    String fileNameToDisplay = (fileName.length() > 20) ? fileName.substring(0, 17) + " ..." : fileName;

                    // check if this is trash file
                    if (!trashFiles.contains("\"name\":\"" + fileName + "\"")) {

                        //validate content type
                        if (file.getContentType().startsWith(fileTypes)) {

                            // validate file size                                
                            if (filesize <= maxFileSize) {

                                // validate maximum number of files
                                if (countFiles < maxFilesNumber) {

                                    logger.log(Level.INFO, "File component id:{0}", file.getName());
                                    logger.log(Level.INFO, "Content type:{0}", file.getContentType());
                                    logger.log(Level.INFO, "Submitted file name:{0}", file.getSubmittedFileName());
                                    logger.log(Level.INFO, "File size:{0}", filesize);

                                    try (InputStream inputStream = file.getInputStream(); FileOutputStream outputStream = new FileOutputStream("D:" + File.separator + "files" + File.separator + file.getSubmittedFileName())) {

                                        int bytesRead = 0;
                                        final byte[] chunck = new byte[1024];
                                        while ((bytesRead = inputStream.read(chunck)) != -1) {
                                            outputStream.write(chunck, 0, bytesRead);
                                            totalReadSize += bytesRead;
                                            push.send((totalReadSize * 100) / totalSize);
                                        }

                                        countFiles++;

                                        FacesContext.getCurrentInstance().addMessage("uploadFormId:fileToUploadId", new FacesMessage(FacesMessage.SEVERITY_INFO, "Upload successfully ended: " + fileNameToDisplay, ""));
                                    } catch (IOException ex) {
                                        FacesContext.getCurrentInstance().addMessage("uploadFormId:fileToUploadId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Upload " + fileNameToDisplay + " failed !", ""));
                                    }
                                } else {
                                    FacesContext.getCurrentInstance().addMessage("uploadFormId:fileToUploadId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "You can upload maxim 5 images !", ""));
                                    break;
                                }
                            } else {
                                FacesContext.getCurrentInstance().addMessage("uploadFormId:fileToUploadId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File: " + fileNameToDisplay + " has more than 2 MB !", ""));
                            }
                        } else {
                            FacesContext.getCurrentInstance().addMessage("uploadFormId:fileToUploadId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File " + fileNameToDisplay + " is not an accepted image !", ""));
                        }
                    }
                }
            }
            if (countFiles == 0) {
                FacesContext.getCurrentInstance().addMessage("uploadFormId:fileToUploadId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "There are no files to upload !", ""));
            }
        }
    }

    public String getTrash() {
        return trash;
    }

    public void setTrash(String trash) {
        this.trash = trash;
    }

    public List<Part> getFiles() {
        return files;
    }

    public void setFiles(List<Part> files) {
        this.files = files;
    }
}
