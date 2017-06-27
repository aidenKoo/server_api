package server_api;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by aiden on 2017-06-27.
 */
public class Board {
    private int seq;
    private String title;
    private String content;
    private Date regdate;
    private ArrayList<BoardFile> filelist;
    public ArrayList<BoardFile> getFilelist() { return filelist; }
    public void setFilelist(ArrayList<BoardFile> filelist) { this.filelist = filelist; }
    public int getSeq() { return seq; } public void setSeq(int seq) { this.seq = seq; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public Date getRegdate() { return regdate; }
    public void setRegdate(Date regdate) { this.regdate = regdate; }
}
