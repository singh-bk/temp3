package com.goldman.interview;

import java.lang.instrument.ClassDefinition;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarFile;

public class EmptyClassTest {
	private static Instrumentation instrumentation = new Instrumentation() {
		
		@Override
		public void setNativeMethodPrefix(ClassFileTransformer arg0, String arg1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void retransformClasses(Class<?>... arg0)
				throws UnmodifiableClassException {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean removeTransformer(ClassFileTransformer arg0) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void redefineClasses(ClassDefinition... arg0)
				throws ClassNotFoundException, UnmodifiableClassException {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean isRetransformClassesSupported() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean isRedefineClassesSupported() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean isNativeMethodPrefixSupported() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean isModifiableClass(Class<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public long getObjectSize(Object arg0) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Class[] getInitiatedClasses(ClassLoader arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Class[] getAllLoadedClasses() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void appendToSystemClassLoaderSearch(JarFile arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void appendToBootstrapClassLoaderSearch(JarFile arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void addTransformer(ClassFileTransformer arg0, boolean arg1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void addTransformer(ClassFileTransformer arg0) {
			// TODO Auto-generated method stub
			
		}
	};
	public static void main(String[] args)
	{
		EmptyClass empty = new EmptyClass();
		Map<Long, Integer> sizeMap = new HashMap<Long, Integer>();
		for(long i=0;i<1000000; i++){
			sizeMap.put(i,2000000);
		}
		System.out.println(sizeMap.size());
		System.out.println(instrumentation.getObjectSize(sizeMap));
	}
}
