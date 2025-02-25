package chap08_board;

public class BoardJob implements BoardInterface {
	public BoardJob() {
		boardList = new BoardBasic[0];
		eventList = new BoardEvent[0];
		noticeList = new BoardNotice[0];
	}

	public BoardBasic[] boardList;
	public BoardEvent[] eventList;
	public BoardNotice[] noticeList;
	
	public int page = 1;
	public int offset = 3; // 한 페이지에 표시할 게시글 수
	public int pageOffset = 5; // 한 번에 표시할 페이지 수

	// 게시글 등록 메서드
	@Override
	public void regist(Object obj) {
		if (obj instanceof BoardEvent) {
			BoardEvent[] newList = new BoardEvent[eventList.length + 1];
			System.arraycopy(eventList, 0, newList, 0, eventList.length);
			newList[newList.length - 1] = (BoardEvent) obj;
			eventList = new BoardEvent[newList.length];
			System.arraycopy(newList, 0, eventList, 0, newList.length);
		} else if (obj instanceof BoardNotice) {
			BoardNotice[] newList = new BoardNotice[noticeList.length + 1];
			System.arraycopy(noticeList, 0, newList, 0, noticeList.length);
			newList[newList.length - 1] = (BoardNotice) obj;
			noticeList = new BoardNotice[newList.length];
			System.arraycopy(newList, 0, noticeList, 0, newList.length);
		} else if (obj instanceof BoardBasic) {
			BoardBasic[] newList = new BoardBasic[boardList.length + 1];
			System.arraycopy(boardList, 0, newList, 0, boardList.length);
			newList[newList.length - 1] = (BoardBasic) obj;
			boardList = new BoardBasic[newList.length];
			System.arraycopy(newList, 0, boardList, 0, newList.length);
		}
	}

	// 특정 게시글 수정 메서드
	@Override
	public void update(String no, Object obj) {
		if (obj instanceof BoardBasic) {
			for(BoardBasic board : boardList) {
				if(board.getNo() == Integer.parseInt(no)) {
					board = (BoardBasic)obj;
					break;
				}
			}
		} else if (obj instanceof BoardEvent) {
			for(BoardEvent board : eventList) {
				if(board.getNo() == Integer.parseInt(no)) {
					board = (BoardEvent)obj;
					break;
				}
			}
		} else if (obj instanceof BoardNotice) {
			for(BoardNotice board : noticeList) {
				if(board.getNo() == Integer.parseInt(no)) {
					board = (BoardNotice)obj;
					break;
				}
			}
		}
	}

	// 특정 게시글 삭제 메서드
	@Override
	public void delete(Menu menu, String no) {
		if (menu == Menu.BASIC) {
			BoardBasic[] newList = new BoardBasic[boardList.length - 1];
			int i=0;
			for(BoardBasic board : boardList) {
				if(board.getNo() != Integer.parseInt(no)) {
					newList[i] = board;
					i++;
				}
			}
			boardList = new BoardBasic[newList.length];
			System.arraycopy(newList, 0, boardList, 0, newList.length);
		}
		else if (menu == Menu.EVENT) {
			BoardEvent[] newList = new BoardEvent[eventList.length - 1];
			int i=0;
			for(BoardEvent board : eventList) {
				if(board.getNo() != Integer.parseInt(no)) {
					newList[i] = board;
					i++;
				}
			}
			eventList = new BoardEvent[newList.length];
			System.arraycopy(newList, 0, eventList, 0, newList.length);
		}
		else if (menu == Menu.NOTICE) {
			BoardNotice[] newList = new BoardNotice[noticeList.length - 1];
			int i=0;
			for(BoardNotice board : noticeList) {
				if(board.getNo() != Integer.parseInt(no)) {
					newList[i] = board;
					i++;
				}
			}
			noticeList = new BoardNotice[newList.length];
			System.arraycopy(newList, 0, noticeList, 0, newList.length);
		}
	}

	// 게시판 별 게시글 조회 메서드 (페이지네이션 적용된 결과)
	@Override
	public Object[] select(Menu menu) {
		BoardBasic[] board = null;
		switch(menu) {
			case Menu.BASIC: board = boardList; break;
			case Menu.EVENT: board = eventList; break;
			case Menu.NOTICE: board = noticeList; break;
			default: return null;
		}
		
		int startIndex = offset * (page-1);
		int count = Math.min(offset, board.length - startIndex);
		BoardBasic[] newList = new BoardBasic[offset];
		System.arraycopy(board, startIndex, newList, 0, count);
		
		return newList;
	}

	// 더미 데이터 생성 메서드
	public void createDummy() {
		for(int i=0; i<100; i++) {
			int random = (int)(Math.random()*100);
			if(i%2==0) {
				BoardBasic board = new BoardBasic("title"+random, "name", "regDate");
				regist(board);
			} else if (i%3==0) {
				BoardEvent board = new BoardEvent("title"+random, "name", "regDate", "eventDate");
				regist(board);
			} else {
				BoardNotice board = new BoardNotice("title"+random, "name", "regDate", "noticeFile");
				regist(board);
			}
		}
	}
}
