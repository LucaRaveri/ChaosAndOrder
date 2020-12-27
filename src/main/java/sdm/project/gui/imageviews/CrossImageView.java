package sdm.project.gui.imageviews;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CrossImageView extends ImageView {

    public CrossImageView(){
        super(new Image(CircleImageView.class.getResourceAsStream("/images/cross.png")));
        setFitHeight(50);
        setFitWidth(50);
    }

}
