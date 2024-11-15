package com.devsuperior.dslist.projections;



public interface GameMinProjection {
    long getId();
    String getTitle();
    int getYear();
    String getImgUrl();
    String getShortDescription();
    int getPosition();
}
