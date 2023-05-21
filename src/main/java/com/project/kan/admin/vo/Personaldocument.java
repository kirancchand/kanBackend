package com.project.kan.admin.vo;

public class Personaldocument {
    private int personaldocument_id;
    private String document_no;
    private int f_documenttype_id;
    private String document;
    public String getDocument_no() {
        return document_no;
    }
    public void setDocument_no(String document_no) {
        this.document_no = document_no;
    }
    public String getDocument() {
        return document;
    }
    public void setDocument(String document) {
        this.document = document;
    }
    public int getPersonaldocument_id() {
        return personaldocument_id;
    }
    public void setPersonaldocument_id(int personaldocument_id) {
        this.personaldocument_id = personaldocument_id;
    }
    public int getF_documenttype_id() {
        return f_documenttype_id;
    }
    public void setF_documenttype_id(int f_documenttype_id) {
        this.f_documenttype_id = f_documenttype_id;
    }

}
