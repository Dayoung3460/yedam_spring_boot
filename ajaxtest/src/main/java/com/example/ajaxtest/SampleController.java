package com.example.ajaxtest;

import com.example.ajaxtest.movie.BoxOfficeVO;
import com.example.ajaxtest.movie.DailyBoxOfficeVO;
import com.example.ajaxtest.movie.MovieVO;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

// @RestController = @Controller + @ResponseBody
// (@Controller는 클래스 단에 설정해주고 @ResponseBody는 원하는 메소드의 반환타입 앞에 붙여줘도됨)
@RestController
@Slf4j
public class SampleController {
  @GetMapping(value = "/getText", produces = MediaType.TEXT_HTML_VALUE)
  public String getText(){
    return "hello";
  }
  
  @GetMapping(value = "/getTextEntity")
  public ResponseEntity<String> getTextEntity(){
    return new ResponseEntity<>("hello", HttpStatus.BAD_REQUEST);
  }
  
  @GetMapping(value = "/getSample")
  public SampleVO getSample(){
    // response headers > content-type > application/json
    // json string type으로 넘겨줌
    // {
    //  "mno": 100,
    //  "firstName": "Dayoung",
    //  "lastName": "Kim"
    //}
    return new SampleVO(100, "Dayoung", "Kim", new Date());
  }
  
  @GetMapping(value = "/getSampleEntity")
  // ResponseEntity: 상태코드랑 같이 넘기고 싶을 때
  public ResponseEntity<SampleVO> getSampleEntity(){
    SampleVO sample = new SampleVO(100, "Dayoung", "Kim", new Date());
    return new ResponseEntity<>(sample, HttpStatus.INTERNAL_SERVER_ERROR); // client에서 500뜸
  }
  
  @GetMapping(value = "/getMap")
  public Map<String, Object> getMap() {
    Map<String, Object> map = new HashMap<>();
    ArrayList<SampleVO> sampleArr = new ArrayList<>();
    
    sampleArr.add(new SampleVO(100, "Dayoung", "Kim", new Date()));
    sampleArr.add(new SampleVO(200, "nam", "Kim", new Date()));
    sampleArr.add(new SampleVO(300, "young", "Kim", new Date()));
    
    map.put("sample", sampleArr);
    map.put("total", 20);
    map.put("success", true);
    return map;
  }
  
  //http://localhost:83/product/food/1
  @GetMapping("/product/{category}/{pid}")
  public String[] getPath(@PathVariable String category,
                          @PathVariable Integer pid) {
    return new String[]{category, String.valueOf(pid)};
  }
  
  @PostMapping("/ticket")
  // client에서 바디에 폼으로 데이터 보내주면(쿼리스트링으로)
  // 알아서 java object로 변환해서 파라미터로 넘겨줌
  
  // client에서 json string(부메랑에서 Raw - json)으로 보내면
  // {"tno": 1, "owner": "kim", "grade": "A"}
  // @RequestBody 설정해줘야함
  public Ticket convert(@RequestBody Ticket ticket) {
    log.info("ticket={}", ticket);
    return ticket;
  }
  
  @PostMapping("/tickets")
  public List<Ticket> tickets(@RequestBody List<Ticket> tickets) {
    log.info("tickets={}", tickets);
    return tickets;
  }
  
// client: body > json string
//  {
//    "list": [
//    {"tno": 1, "owner": "kim", "grade": "A"},
//    {"tno": 2, "owner": "kim2", "grade": "B"},
//    {"tno": 3, "owner": "kim3", "grade": "C"}
//  ],
//    "sample": {
//    "mno": 1004,
//      "firstName": "You",
//      "lastName": "Kim"
//  },
//    "cnt": 100,
//    "regdate": "2025-01-16"
//  }
  
  // status: 406 Not Acceptable 
  // : CompVO class에 @Data 설정해줬는지 확인
  // 서버는 요청을 이해했지만 클라이언트가 요구한 형식의 응답을 제공할 수 없는 상황
  @PostMapping("/comp")
  public CompVO comp(@RequestBody CompVO comp) {
    return comp;
  }
  
  // VO CLASS(A VO class, or Value Object class, is an object that represents a value or concept in an application)
  // 만들기 귀찮을 때
  @PostMapping("/comp/simple")
  public JsonNode comp(@RequestBody JsonNode jsonNode) {
    log.info("jsonNode={}", jsonNode.get("list").get(0).get("owner").asText());
    return jsonNode;
  }
  
  @GetMapping("/movie")
  public String movie(@RequestParam(defaultValue = "20250115", required = false) String date) {
    RestTemplate restTemplate = new RestTemplate();
    
    String url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=12664b24453335d2c3eca0fdc4b3b013&targetDt=" + date;
    
    JsonNode node = restTemplate.getForObject(url, JsonNode.class);
    String name = node.get("boxOfficeResult").get("dailyBoxOfficeList").get(0).get("movieNm").asText();
    log.info("name:{}", name);
    return name;
  }
  
  @PostMapping("/movies")
  public BoxOfficeVO movies(@RequestBody BoxOfficeVO boxOfficeVO) {
    return boxOfficeVO;
  }
}
