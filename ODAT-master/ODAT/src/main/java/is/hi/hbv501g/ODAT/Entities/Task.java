package is.hi.hbv501g.ODAT.Entities;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private Date startTime;
    private Date endTime;
    private ArrayList<Tfolder> folders; // = new ArrayList<Tfolder>();

    public ArrayList<Tfolder> getFolders() {
        return this.folders;
    }

    public void setFolders(ArrayList<Tfolder> folders) {
        this.folders = folders;
    }

    public Task() {

    }

    public Task(String title, Date startTime, Date endTime, ArrayList<Tfolder> folders) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.folders = folders;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}
