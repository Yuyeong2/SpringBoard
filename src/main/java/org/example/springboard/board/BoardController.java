package org.example.springboard.board;

import com.sun.istack.internal.NotNull;
import org.example.springboard.board.model.BoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService service;

    @GetMapping("/list")
    public void list(Model model) {
        model.addAttribute("list", service.selBoardList());
    }
    @GetMapping("/detail")
    public void detail(Model model, BoardEntity entity) {
        service.updBoardHitsUp(entity);
        model.addAttribute("data", service.selBoard(entity));
    }
    @GetMapping("/write")
    public void write() {}

    @PostMapping("/write")
    public String writeProc(BoardEntity entity, RedirectAttributes reAttr) {
        System.out.println(entity);
        int result = service.insBoard(entity);
        if(result == 0) {
            reAttr.addFlashAttribute("msg", "글 등록에 실패하였습니다.");
            reAttr.addFlashAttribute("data", entity);
            return "redirect:/board/write";
        }
        return "redirect:/board/list";
    }
    @GetMapping("/mod")
    public void mod(Model model, BoardEntity entity, @NotNull HttpServletRequest req) throws Exception {
        Map<String, ?> map = RequestContextUtils.getInputFlashMap(req);
        BoardEntity data = map != null ? (BoardEntity) map.get("data") : service.selBoard(entity);
        model.addAttribute("data", data);
    }
    @PostMapping("/mod")
    public String modProc(BoardEntity entity, RedirectAttributes reAttr) {
        int result = service.updBoard(entity);
        if (result == 0) {
            reAttr.addAttribute("iboard", entity.getIboard());
            reAttr.addFlashAttribute("msg", "글 수정에 실패하였습니다.");
            reAttr.addFlashAttribute("data", entity);
            return "redirect:/board/mod";
        }
            return "redirect:/board/detail?iboard=" + entity.getIboard();
    }
    @GetMapping("/del")
    public String delProc(BoardEntity entity, RedirectAttributes reAttr) {
        int result = service.delBoard(entity);
        if(result == 0) {
            reAttr.addFlashAttribute("msg", "글 삭제에 실패하였습니다.");
            reAttr.addAttribute("iboard", entity.getIboard());
            return "redirect:/board/detail";
        }
        return "redirect:/board/list";
    }
}
