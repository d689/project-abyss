package abyss.world.blocks.entropy;

import arc.graphics.*;
import mindustry.entities.Effect;
import mindustry.content.*;
import mindustry.gen.*;
import mindustry.world.Block;
import abyss.world.blocks.entropy.*;

/*based on Endless Rusting's pulse system
wont be available on the next releases but i will work on it*/

public class EntropyBlock extends Block {
	public float maxEntropy = 100f;

	public Effect entropyEffect = Fx.none;
	public Color entropyColor = Color.valueOf("C46CC4");

	public EntropyBlock(String name) {
		super(name);
		solid = true;
		update = true;
		destructible = true;
	}

	public class EntropyBlockBuild extends Building implements EntropyBlockc {
		public EntropyStorage entropy = new EntropyStorage();

		@Override
		public void overflowEntropy() {
			if (entropy.entropy > maxEntropy) {
				kill();
			entropyEffect.at(x, y);
			}
		}

		@Override
		public EntropyStorage entropyStorage() {
			return entropy;
		}

		@Override
		public void updateTile() {
			overflowEntropy();
			normalizeEntropy();
		}
	}
}