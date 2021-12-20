package render;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import game.GameLogic;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import render.IRenderable;

public class RenderableHolder {
	private static RenderableHolder single_instance = null;
	
    public static RenderableHolder getInstance()
    {
        if (single_instance == null)
            single_instance = new RenderableHolder();
 
        return single_instance;
    }
    
	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;

	
	private RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}


	
	public void add(IRenderable entity) {
		entities.add(entity);
		Collections.sort(entities, comparator);

	}

	public void update() {
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (entities.get(i).isDestroyed())
				entities.remove(i);
		}
	}

	public List<IRenderable> getEntities() {
		return entities;
	}
	
	public void clear() {
		entities.clear();
		single_instance = null;
	}
	
	
}
