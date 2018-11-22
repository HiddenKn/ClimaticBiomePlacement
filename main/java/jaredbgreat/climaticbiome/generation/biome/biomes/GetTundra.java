package jaredbgreat.climaticbiome.generation.biome.biomes;

import jaredbgreat.climaticbiome.generation.biome.BiomeList;
import jaredbgreat.climaticbiome.generation.biome.LeafBiome;
import jaredbgreat.climaticbiome.generation.biome.TempDoubleBiome;
import jaredbgreat.climaticbiome.generation.generator.ChunkTile;

public class GetTundra extends BiomeList {
	private static GetTundra tundra;
	private GetTundra() {
		super();
	}
	
	
	public void init() {
		addItem(new LeafBiome(12), 5);
		addItem(new TempDoubleBiome(140, 2, 12));
		addItem(new TempDoubleBiome(12,  2, 30));
	}
	
	
	public GetTundra getTundra() {
		if(tundra == null) {
			tundra = new GetTundra();
		}
		return tundra;
	}

}
