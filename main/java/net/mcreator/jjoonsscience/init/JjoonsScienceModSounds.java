
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jjoonsscience.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.jjoonsscience.JjoonsScienceMod;

public class JjoonsScienceModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, JjoonsScienceMod.MODID);
	public static final RegistryObject<SoundEvent> STEAM = REGISTRY.register("steam", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("jjoons_science", "steam")));
	public static final RegistryObject<SoundEvent> GETAIR = REGISTRY.register("getair", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("jjoons_science", "getair")));
	public static final RegistryObject<SoundEvent> MYTURN = REGISTRY.register("myturn", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("jjoons_science", "myturn")));
}
