package com.example.batch.job;

import com.example.batch.processor.SampleItemProcessor;
import com.example.batch.reader.SampleItemReader;
import com.example.batch.writer.SampleItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleJobConfig {
    @Bean
    public Job sampleJob(JobBuilderFactory jobBuilderFactory, Step sampleStep) {
        return jobBuilderFactory.get("sampleJob")
                .incrementer(new RunIdIncrementer())
                .flow(sampleStep)
                .end()
                .build();
    }

    @Bean
    public Step sampleStep(StepBuilderFactory stepBuilderFactory,
                           SampleItemReader reader,
                           SampleItemProcessor processor,
                           SampleItemWriter writer) {
        return stepBuilderFactory.get("sampleStep")
                .<String, String>chunk(5)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}

