package com.mung.square.dto;

import java.util.List;

public class ReviewResponseDTO {
    private String reviewNo;
    private String title;
    private String id;
    private String writeDate;
    private List<ReviewFileDTO> fileMetadata;

    // Getter, Setter, Constructor

    public String getReviewNo() {
        return reviewNo;
    }

    public void setReviewNo(String reviewNo) {
        this.reviewNo = reviewNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
    }

    public List<ReviewFileDTO> getFileMetadata() {
        return fileMetadata;
    }

    public void setFileMetadata(List<ReviewFileDTO> fileMetadata) {
        this.fileMetadata = fileMetadata;
    }
}
