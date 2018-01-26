package com.rajan.lambdaExpression.functionalInterface;

@FunctionalInterface
public interface Processor<E> {

	E process(E i);

}
