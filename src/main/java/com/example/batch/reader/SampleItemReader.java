package com.example.batch.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Component
public class SampleItemReader implements ItemReader<String> {
    private final Iterator<String> data;

    public SampleItemReader() {
        List<String> items = Arrays.asList("Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot");
        this.data = items.iterator();
    }

    @Override
    public String read() {
        return data.hasNext() ? data.next() : null;
    }
}

