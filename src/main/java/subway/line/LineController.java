package subway.line;

import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/lines")
@RequiredArgsConstructor
public class LineController {

    private final LineService lineService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LineResponse createLine(@RequestBody final LineCreateRequest lineCreateRequest) {

        return lineService.createLine(lineCreateRequest);
    }

    @GetMapping("/{lineId}")
    public LineResponse getLine(@PathVariable final Long lineId) {

        return lineService.getLine(lineId);
    }

    @GetMapping
    public List<LineResponse> getLines(){

        return lineService.getAll();
    }

    @PutMapping("/{lineId}")
    public void editLine(
            @PathVariable final Long lineId,
            @RequestBody final LineEditRequest lineEditRequest
    ) {

        lineService.editLine(lineId, lineEditRequest);
    }

    @DeleteMapping("/{lineId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLine(@PathVariable final Long lineId) {

        lineService.deleteById(lineId);
    }

}
