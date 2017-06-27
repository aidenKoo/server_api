package server_api;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by aiden on 2017-06-23.
 */
@Controller
public class MainContoller {

    protected Logger logger = Logger.getLogger(this.getClass());


    @RequestMapping("/")
    public String Index(Model model) throws Exception {

        logger.info("index.....");

        System.out.println("index");

        return "index";

    }


    @RequestMapping("/hi.do")
    public String hi(Model model) throws Exception {

        logger.info("hi.....");

        System.out.println("hi");

        return "index";

    }

    @RequestMapping(value = "/jsonTest.do")
    public @ResponseBody
    Object jsonTest() { //가상의 배열및 리스트에 데이터 add
        Board board = new Board();
        board.setSeq(1);
        board.setTitle("제목");
        board.setContent("내요내용내용");
        board.setRegdate(new Date());
        ArrayList<BoardFile> filelist = new ArrayList<BoardFile>();
        BoardFile boardFile = null; boardFile = new BoardFile();
        boardFile.setFileSeq(1); boardFile.setFileName("파일명1");
        boardFile.setFileSize(1000); filelist.add(boardFile);
        boardFile = new BoardFile();
        boardFile.setFileSeq(2);
        boardFile.setFileName("파일명2");
        boardFile.setFileSize(25645);
        filelist.add(boardFile);
        board.setFilelist(filelist);

        logger.info("jsonTest.....");

        System.out.println("jsonTest");
            return board;
    }
}

