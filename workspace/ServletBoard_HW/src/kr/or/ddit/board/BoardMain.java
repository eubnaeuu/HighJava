package kr.or.ddit.board;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

//import org.apache.log4j.Logger;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.vo.BoardVO;

/*
	위의 테이블을 작성하고 게시판을 관리하는
다음 기능들을 구현하시오.

기능 구현하기 ==> 전체 목록 출력, 새글작성, 수정, 삭제, 검색 
 
------------------------------------------------------------

게시판 테이블 구조 및 시퀀스

create table jdbc_board(
    board_no number not null,  -- 번호(자동증가)
    board_title varchar2(100) not null, -- 제목
    board_writer varchar2(50) not null, -- 작성자
    board_date date not null,   -- 작성날짜
    board_content clob,     -- 내용
    constraint pk_jdbc_board primary key (board_no)
);
create sequence board_seq
    start with 1   -- 시작번호
    increment by 1; -- 증가값
		
----------------------------------------------------------

// 시퀀스의 다음 값 구하기
//  시퀀스이름.nextVal

*/
public class BoardMain {
	
	private BoardService BoardService;
	
	public BoardMain() {
		BoardService = new BoardServiceImpl();
	}
	
	private Scanner scan = new Scanner(System.in);

	// 로그 생성
//	private static final Logger SQL_LOGGER = Logger.getLogger("log4jexam.sql.Query");
//	private static final Logger PARAM_LOGGER = Logger.getLogger("log4jexam.sql.Parameter");
//	private static final Logger RESULT_LOGGER = Logger.getLogger(BoardMain.class);
	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu(){
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 조회");
		System.out.println("  2. 작성");
		System.out.println("  3. 수정");
		System.out.println("  4. 삭제");
		System.out.println("  5. 검색");
		System.out.println("  0. 종료");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}
	
	/**
	 * 프로그램 시작메서드
	 */
	public void start(){
		int choice;
		do{
			displayMenu(); //메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch(choice){
				case 1 :  // 조회
					select();
					break;
				case 2 :  // 작성
					insert();
					break;
				case 3 :  // 수정
					update();
					break;
				case 4 :  // 삭제
					delete();
					break;
				case 5 :  // 검색
					search();
					break;
				case 0 : // 종료
					System.out.println("작업을 마칩니다.");
					break;
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice!=0);
	}	
	
	
	/**
	 *  키워드를 이용한 게시글 검색 메서드
	 */
	private void search() {
		String column;
		String keword;
		scan.nextLine();
		List<BoardVO> boardList = null;
			System.out.println("1.제목검색\t2.내용검색\t3.작성자검색");
			String input = scan.nextLine();
			System.out.println("단어입력>");
			keword = scan.nextLine();
			BoardVO bv = new BoardVO();
			switch (input) {
			case "1": {
				column = "board_title";
				bv.setBoardTitle(keword);
				boardList = BoardService.searchBoard(bv);
				break;
			}
			case "2": {
				column = "board_content";
				bv.setBoardContent(keword);
				boardList = BoardService.searchBoard(bv);
				break;
			}
			case "3": {
				column = "board_writer";
				bv.setBoardWriter(keword);
				boardList = BoardService.searchBoard(bv);
				break;
			}
			}

			System.out.println("-------------------------------------------");
			System.out.println(" 글번호\t제목\t작성자\t일자\t내용");
			System.out.println("-------------------------------------------");
	
			
	for(BoardVO bv1 : boardList){
		System.out.println(bv1.getBoardNo()+"\t"+bv1.getBoardTitle()+"\t"+bv1.getBoardWriter()+"\t"+bv1.getBoardDate()+"\t"+bv1.getBoardContent());
	}
	
	System.out.println("-------------------------------------------");
	System.out.println("출력 작업 끝...");
			
	}

	/**
	 * 게시글을  삭제하는 메서드(입력받은 게시글번호를 이용하여 삭제)
	 */
	private void delete() {
		
		System.out.println("삭제하고 싶은 글의 번호를 입력해주세요>");
		String boardNo = scan.next();

		int cnt =BoardService.deleteBoard(boardNo);
		
			if(cnt > 0 ) {
				System.out.println("글번호가 " + boardNo + "번 게시글을 삭제 완료했습니다");
			} else {
				System.out.println("글번호가 " + boardNo + "번 게시글을 삭제 실패!!!");
			}
			
	}

	/**
	 * 게시글을 수정하는 메서드
	 */
	
	private void update() {
		boolean chk = false;
		String boardNo = null;
		String column = null;
		String content = null;
		int input=5;//임시 
		do{
			scan.nextLine();
			System.out.println();
			System.out.println("수정하고 싶은 글의 번호를 입력해주세요>");
			
			boardNo = scan.nextLine();
			
			chk = BoardService.checkBoard(boardNo);
				
			if(!chk) {
				System.out.println("글번호가 " + boardNo + "인 게시글이 존재하지 않습니다");
				System.out.println("다시 입력해 주세요");
			}
			
			
		}while(chk == false);
		
		int cnt = 0;
		out : while(true) {
			System.out.println("1.작성자\t2.제목\t3.내용\t0.뒤로");
			input = Integer.valueOf(scan.nextLine());
			BoardVO bv = new BoardVO();
			switch (input) {
			case 1: {
				column ="board_writer";
				System.out.println("작성자>");
				String updatecontent = scan.nextLine();
				
				bv.setBoardWriter(updatecontent);
				bv.setBoardNo(boardNo);
				
				cnt = BoardService.updateBoard(bv);
				if(cnt > 0 ) {
					System.out.println(boardNo + "번 게시글의  수정 작업 성공");
					
				} else {
					System.out.println(boardNo + "번 게시글의  수정 작업 실패!!");
				}
				break;
				}
			case 2: {
				column ="board_title";
				System.out.println("제목>");
				String updatecontent = scan.nextLine();
				
				bv.setBoardTitle(updatecontent);
				bv.setBoardNo(boardNo);
				
				cnt = BoardService.updateBoard(bv);
				if(cnt > 0 ) {
					System.out.println(boardNo + "번 게시글의  수정 작업 성공");
					
				} else {
					System.out.println(boardNo + "번 게시글의  수정 작업 실패!!");
				}
				break;
				}
			case 3: {
				column ="board_content";
				System.out.println("내용>");
				
				String updatecontent = scan.nextLine();
				
				bv.setBoardContent(updatecontent);
				bv.setBoardNo(boardNo);
				
				cnt = BoardService.updateBoard(bv);
				
				if(cnt > 0 ) {
					System.out.println(boardNo + "번 게시글의  수정 작업 성공");
					
				} else {
					System.out.println(boardNo + "번 게시글의  수정 작업 실패!!");
				}
				break;
				}
			case 0: break out;
			}
		}
	}
	/**
	 * 전체 게시글을 출력하는 메서드
	 */
	private void select() {
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println(" 글번호\t제목\t작성자\t일자\t내용");
		System.out.println("-------------------------------------------");
		
		List<BoardVO> boardList = BoardService.getAllBoardlist();
		
		for(BoardVO bv : boardList){
			System.out.println(bv.getBoardNo()+"\t"+bv.getBoardTitle()+"\t"+bv.getBoardWriter()+"\t"+bv.getBoardDate()+"\t"+bv.getBoardContent());
		}
		
		System.out.println("-------------------------------------------");
		System.out.println("출력 작업 끝...");
	}

	/**
	 *  게시글을 추가하기 위한 메서드
	 */
	private void insert() {
		scan.nextLine();

			System.out.println();
			

		System.out.println("작성자>");
		String boardwriter = scan.nextLine();
		
		System.out.println("제목>");
		String boardtitle = scan.nextLine();

		System.out.println("내용>");
		String boardcontent = scan.nextLine();
		
	   BoardVO bv = new BoardVO();
		
	   bv.setBoardWriter(boardwriter);
	   bv.setBoardTitle(boardtitle);
	   bv.setBoardContent(boardcontent);
	   
	   
		int cnt = BoardService.insertBoard(bv);
		
		System.out.println(cnt);
			if(cnt > 0 ) {
				System.out.println(boardwriter + "님의 게시글 작성 작업 성공");
			} else {
				System.out.println(boardwriter + "님의 게시글 작성 실패!!!");
			}
	}
	/**
	 * 게시글번호를 이용하여 게시글이 있는지 알려주는 메서드
	 * @return 존재하면 true, 없으면 false
	 */
	

	public static void main(String[] args) {
		BoardMain boardObj = new BoardMain();
		boardObj.start();
	}

}






