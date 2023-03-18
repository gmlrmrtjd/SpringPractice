package com.example.springpractice.controller;

import com.example.springpractice.domain.SampleVO;
import com.example.springpractice.domain.Ticket;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/sample")
@Log4j2
public class SampleController {

    // 객체의 반환
    @GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8") // value: 경로, produces: content-type설정
    public String getText() {

        log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);

        return "안녕하세요";
    }

    @GetMapping(value = "/getSample"
                ,produces = {MediaType.APPLICATION_JSON_VALUE,
                            MediaType.APPLICATION_XML_VALUE})
    public SampleVO getSample() {
        return new SampleVO(112, "스타", "로드");
    }

    @GetMapping(value = "getSample2")   // produces 속성 생략 가능
    public SampleVO getSample2() {
        return new SampleVO(113, "로켓", "라쿤");
    }

    // 컬렉션 타입의 객체 반환(여러 데이터를 한 번에 전송)
    @GetMapping(value = "/getList")
    public List<SampleVO> getList() {
        return IntStream.range(1, 10)
                .mapToObj(i -> new SampleVO(i, i + "First", i + " Last"))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/getMap")
    public Map<String, SampleVO> getMap() {
        Map<String, SampleVO> map = new HashMap<>();
        map.put("First", new SampleVO(111, "그루트", "주니어"));

        return map;
    }

    // ResponseEntity 타입
    // 데이터 자체를 전송하는 방식으로 처리, 요청한 쪽에서 정상 또는 비정상 데이터를 구분할 수 있는 방법 제공해야함.
    // ResponseEntity: 데이터와 함께 HTTP 헤더의 상태 메시지 등을 같이 전달하는 용도로 사용
    @GetMapping(value = "/check", params = { "height", "weight" }, produces = {MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<SampleVO> check(Double height, Double weight) {
        SampleVO vo = new SampleVO(0, "" + height, "" + weight);

        ResponseEntity<SampleVO> result = null;

        if (height < 150) {
            result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);    // 502(bad gateway) 상태코드
        } else {
            result = ResponseEntity.status(HttpStatus.OK).body(vo); // 200(ok) 상태코드
        }

        return result;
    }

    // @RestController에서 파라미터
    // @PathVariable: URL 경로의 일부를 파라미터로 사용할 때
    @GetMapping("/product/{cat}/{pid}")
    public String[] getPath(
            @PathVariable("cat") String cat,
            @PathVariable("pid") Integer pid) {

        return new String[] {"category: " + cat, "productid: " + pid};
    }

    // @RequestBody: 전달된 요청(request)의 내용(body)을 이용해서 해당 파라미터의 타입으로 변환 요구
    @PostMapping("/ticket")
    public Ticket convert(@RequestBody Ticket ticket) {
        log.info("convert......ticket" + ticket);

        return ticket;
    }
}
