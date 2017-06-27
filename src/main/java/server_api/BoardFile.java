package server_api;

/**
 * Created by aiden on 2017-06-27.
 */
public class BoardFile {
    private int fileSeq;
    private String fileName;
    private int fileSize;
    public int getFileSeq() {
        return fileSeq;
    }
    public void setFileSeq(int fileSeq) {
        this.fileSeq = fileSeq;
    } public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    } public int getFileSize() {
        return fileSize;
    }
    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

}
