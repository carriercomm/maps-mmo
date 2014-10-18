package com.dubhacks.maps_mmo.map.renderers;

import com.dubhacks.maps_mmo.map.GameMap;
import com.dubhacks.maps_mmo.map.GeoJsonFileType;
import org.geojson.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public class WaterRenderer extends Renderer {
    public WaterRenderer(GameMap map) {
        super(map);
    }

    @Override
    public void render(List<Feature> features) throws IOException {
        BufferedImage image = this.allocateImage();

        for (Feature waterArea : features) {
            GeoJsonObject geometry = waterArea.getGeometry();
            if (geometry instanceof Polygon) {
                this.draw((Polygon) geometry, image);
            } else if (geometry instanceof LineString) {
                this.draw((LineString) geometry, image);
            }
        }

        this.write(image);
    }

    @Override
    public GeoJsonFileType getFileType() {
        return GeoJsonFileType.WATER;
    }
}
