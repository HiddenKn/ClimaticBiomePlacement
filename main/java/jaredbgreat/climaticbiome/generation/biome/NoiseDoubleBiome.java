package jaredbgreat.climaticbiome.generation.biome;

import jaredbgreat.climaticbiome.generation.generator.ChunkTile;

import java.util.StringTokenizer;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.IForgeRegistry;

public class NoiseDoubleBiome implements IBiomeSpecifier {
	private final long a, b;
	private final int boundary;
	
	
	public NoiseDoubleBiome(long a, int boundary, long b) {
		this.a = a;
		this.b = b;
		this.boundary = boundary;
	}
	
	
	public NoiseDoubleBiome(Biome a, int boundary, Biome b) {
		this.a = Biome.getIdForBiome(a);
		this.b = Biome.getIdForBiome(b);
		this.boundary = boundary;
	}
	
	
	public NoiseDoubleBiome(String a, int boundary, String b, IForgeRegistry biomeReg) {
		StringTokenizer tokens = new StringTokenizer(a, ":");
		if(tokens.countTokens() < 3) {
			this.a = Biome.getIdForBiome((Biome)biomeReg.getValue(new ResourceLocation(a)));
		} else {
			this.a = Biome.getIdForBiome((Biome)biomeReg
					.getValue(new ResourceLocation(tokens.nextToken() + ":" + tokens.nextToken())))
					+ (Long.parseLong(tokens.nextToken()) << 32);
		}
		tokens = new StringTokenizer(b, ":");
		if(tokens.countTokens() < 3) {
			this.b = Biome.getIdForBiome((Biome)biomeReg.getValue(new ResourceLocation(b)));
		} else {
			this.b = Biome.getIdForBiome((Biome)biomeReg
					.getValue(new ResourceLocation(tokens.nextToken() + ":" + tokens.nextToken())))
					+ (Long.parseLong(tokens.nextToken()) << 32);
		}
		this.boundary = boundary;
	}
	

	@Override
	public long getBiome(ChunkTile tile) {
		if(tile.getNoise() < boundary) {
			return a;
		} else {
			return b;
		}
	}


	@Override
	public boolean isEmpty() {
		return false;
	}

}
