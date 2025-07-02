package com.example.ec.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class TourRating {

    @Id
    private String id;

    private String tourId;

    @NotNull
    private Integer customerId;

    @Min(0)
    @Max(5)
    private Integer score;

    @Size(max = 255)
    private String comment;

    public TourRating(String tourId, Integer customerId, Integer score, String comment) {
        this.tourId = tourId;
        this.customerId = customerId;
        this.score = score;
        this.comment = comment;
    }

    protected TourRating() {
    }

    public Integer getScore() {
        return score;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getComment() {
        return comment;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourRating that = (TourRating) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(tourId, that.tourId) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(score, that.score) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tourId, customerId, score, comment);
    }

    @Override
    public String toString() {
        return "TourRating{" +
                "id='" + id + '\'' +
                ", tourId='" + tourId + '\'' +
                ", customerId=" + customerId +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                '}';
    }
}