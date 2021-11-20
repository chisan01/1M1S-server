//package com.m1s.m1sserver.api.admin.enviroment;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/admin/environment")
//public class EnvironmentController {
//    @Autowired
//    private EnvironmentRepository environmentRepository;
//
//    @PostMapping
//    public Environment addEnvironment(@RequestParam String name, @RequestParam String value) {
//        Environment e = new Environment();
//        e.setName(name);
//        e.setValue(value);
//        environmentRepository.save(e);
//        return e;
//    }
//
//    @GetMapping("/all")
//    public Iterable<Environment> getAllEnvironment() {
//        return environmentRepository.findAll();
//    }
//
//    @GetMapping
//    public Environment getEnvironment(@RequestParam String name) {
//        return environmentRepository.findByName(name);
//    }
//
//    @PutMapping
//    public Environment editEnvironment(@RequestParam String name, @RequestParam String value) {
//        Environment e = environmentRepository.findByName(name);
//        e.setValue(value);
//        environmentRepository.save(e);
//        return e;
//    }
//
//    @DeleteMapping
//    public Environment delEnvironment(@RequestParam String name) {
//        Environment e = environmentRepository.findByName(name);
//        environmentRepository.deleteById(e.getId());
//        return e;
//    }
//}
