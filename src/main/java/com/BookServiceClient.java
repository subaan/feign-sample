package com;

import java.util.List;

import feign.Feign;
import feign.Request;
import feign.RequestTemplate;
import feign.Target;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;

/**
 * Created by gemini on 15/6/16.
 */
public class BookServiceClient {

    static  class DynamicAuthTokenTarget<T> implements Target<T> {
        public DynamicAuthTokenTarget(Class<T> clazz) {

        };

        @Override
        public Class<T> type() {
            return null;
        }

        @Override
        public String name() {
            return null;
        }

        @Override
        public String url() {
            return null;
        }

        @Override
        public Request apply(RequestTemplate input) {


                input.insert(0, "http://localhost:8081/api");

            input.header("X-Auth-Token", "");


            return input.request();
        }
    }


    public static void main(String[] args) {
        DomainService domainService = (DomainService) Feign.builder().contract(new JAXRSContract()).encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder()).target(DomainService.class, "http://localhost:8081/api");

        System.out.println("fetching existing domains   ..");
        Domain books = domainService.get(1L);
        System.out.println(String.format("%s books received", books.getAliasName()));

    }
}
