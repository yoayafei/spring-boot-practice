package top.yyf.my.test.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.yyf.my.test.common.ResponseResult;
import top.yyf.my.test.entity.Question;
import top.yyf.my.test.service.QuestionService;


import java.util.List;


@RestController
@RequestMapping("/api/questions")
@AllArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.list();
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id) {
        return questionService.getById(id);
    }

    

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean createQuestion(@RequestBody Question question) {
        return questionService.save(question);
    }

    //更新商品
    @PutMapping("/{id}")
    public Boolean updateQuestion(@PathVariable Long id, @RequestBody Question questionDetails) {
        questionDetails.setId(id);
        return questionService.updateById(questionDetails);
    }

    //删除商品
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteQuestion(@PathVariable Long id) {
        return questionService.removeById(id);
    }
}