package com.dawidkotarba.playground.integration;

/**
 * Created by Dawid Kotarba on 13.11.2015.
 */
public class ResponseWrapper<T> {

    T response;

    public ResponseWrapper(T response) {
        this.response = response;
    }

    public T getResponse() {
        return response;
    }
}
