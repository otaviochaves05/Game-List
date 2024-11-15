package com.devsuperior.dslist.projections;



public interface GameMinProjection {
    long getId();
    String getTitle();
    int getGameYear();
    String getImgUrl();
    String getShortDescription();
    int getPosition();
}
