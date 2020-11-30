package com.example.mynotepad.bean;

public class NotepadBean {
    private String id;
    private String notepadAuthor;//记录的作者
    private String notepadContent;//记录的内容
    private String notepadTime;//保存记录的时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotepadAuthor() {
        return notepadAuthor;
    }

    public void setNotepadAuthor(String notepadAuthor) {
        this.notepadAuthor = notepadAuthor;
    }

    public String getNotepadContent() {
        return notepadContent;
    }

    public void setNotepadContent(String notepadContent) {
        this.notepadContent = notepadContent;
    }

    public String getNotepadTime() {
        return notepadTime;
    }

    public void setNotepadTime(String notepadTime) {
        this.notepadTime = notepadTime;
    }
}
