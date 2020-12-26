package it.units.sdm.project.gui.imageviews;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CircleImageView extends ImageView {

    public CircleImageView(){
        super(new Image(CircleImageView.class.getResourceAsStream("/images/circle.png")));
        setFitHeight(50);
        setFitWidth(50);
    }

}
