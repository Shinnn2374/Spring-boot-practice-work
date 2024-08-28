package com.example.second_task.config;

import com.example.second_task.stud.StudentCommands;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AppConfig
{
    private final StudentCommands studentCommands;
    private final Environment environment;

    public AppConfig(StudentCommands studentCommands, Environment environment) {
        this.studentCommands = studentCommands;
        this.environment = environment;
    }

    @Bean
    public CommandLineRunner commandLineRunner()
    {
        boolean env = environment.getProperty("app.create.students.on.start", Boolean.class, false);
        if (env == true)
        {
            studentCommands.add();
        }
        return (args) -> {
        };
    }
}
