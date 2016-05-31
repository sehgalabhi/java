package com.java8.basic;

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}