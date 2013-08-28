package com.kodehawa.ce.forge.common.asm;

import static org.objectweb.asm.Opcodes.ASM4;
import net.minecraft.launchwrapper.IClassTransformer;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

import com.kodehawa.ce.CheatingEssentials;


public class BlockTransformer implements IClassTransformer {

	String shouldSideBeRenderedMethodName;
	String shouldSideBeRenderedMethodDesc;

	
	@Override
	public byte[] transform(String arg0, String arg1, byte[] arg2) {
		// TODO Auto-generated method stub
        if (arg1.equals("net.minecraft.client.block.Block")) {

            CheatingEssentials.CELogAgent("Patching Class Block (" + arg0 + ")");
            
            shouldSideBeRenderedMethodName =
                    CETranslator.getMapedMethodName("Block", "shouldSideBeRendered");
            shouldSideBeRenderedMethodDesc =
                    CETranslator.getMapedMethodDesc("Block", "shouldSideBeRendered");

            System.out.println(shouldSideBeRenderedMethodName);
            System.out.println(shouldSideBeRenderedMethodDesc);


            ClassReader cr = new ClassReader(arg2);
            ClassNode cn = new ClassNode(ASM4);

            cr.accept(cn, 0);


            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);

            CheatingEssentials.CELogAgent("Patched Class Block (" + arg0 + ")");
            return cw.toByteArray();

        } else {
            return arg2;
        }
	}




}
