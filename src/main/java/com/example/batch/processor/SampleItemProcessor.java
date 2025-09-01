package com.example.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class SampleItemProcessor implements ItemProcessor<String, String> {
    @Override
    public String process(String item) {
        // Example processing: convert to uppercase
        return item.toUpperCase();
    }
}

