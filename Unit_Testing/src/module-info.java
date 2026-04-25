/**
 * 
 */
/**
 * 
 */
module Unit_Testing {
	requires org.junit.jupiter.api;
	requires org.junit.jupiter.engine;
	 opens assignment.array_reverse.test to org.junit.platform.commons;
	requires junit;
	requires jdk.incubator.vector;
	requires org.junit.jupiter.params;
}