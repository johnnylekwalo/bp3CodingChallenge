package com.bp3.backend;

import com.bp3.backend.model.ProcessDiagram;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProcessController {

    @ResponseBody
    @PostMapping("/reduce")
    public ProcessDiagram reduce(@RequestBody ProcessDiagram process) {
        ProcessDiagram processReduced = process.filterHumanTasks(process);
        return processReduced;
    }
}
