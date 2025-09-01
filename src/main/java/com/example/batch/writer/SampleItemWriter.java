package com.example.batch.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class SampleItemWriter implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> items) {
        // Example writing: print to console
        items.forEach(System.out::println);
    }
}

