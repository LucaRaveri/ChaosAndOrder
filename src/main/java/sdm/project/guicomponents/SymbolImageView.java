package sdm.project.guicomponents;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sdm.project.core.entities.Symbol;

import static sdm.project.core.entities.Symbol.CROSS;

public class SymbolImageView extends ImageView {

    public SymbolImageView(Symbol symbol) {

        super(new Image(SymbolImageView.class.getResourceAsStream((symbol == CROSS) ? "/images/cross.png" : "/images/circle.png")));

        setCache(true);
        setSmooth(true);
        setFitHeight(50);
        setFitWidth(50);
    }

}
