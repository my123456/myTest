package design;
public enum State {
	// 开始浏览
	READ_SKIP {
		@Override
		public State read(Character c) {
			switch (c) {
			case '/':
				return FIND_VIRGULE;

			default:
				return READ_SKIP;
			}
		}
	},
	// 发现斜杠
	FIND_VIRGULE {
		@Override
		public State read(Character c) {
			switch (c) {
			case '/':
				return DOUBLE_VIRGULE;
			case '*':
				return COMMENT_START;
			default:
				return READ_SKIP;
			}
		}
	},
	// 发现双斜杠
	DOUBLE_VIRGULE {
		@Override
		public State read(Character c) {
			switch (c) {
			case '\n':
				return END_VIRGULE;
			default:
				return VIRGULE_CONTINUE;
			}
		}
	},

	VIRGULE_CONTINUE {
		@Override
		public State read(Character c) {
			switch (c) {
			case '\n':
				return END_VIRGULE;
			default:
				return VIRGULE_CONTINUE;
			}
		}
	},
	// '/*' 后继状态处理 (文本注释or文档注释开始)
	COMMENT_START {
		@Override
		public State read(Character c) {
			switch (c) {
			case '*':
				return DOCUMENT_START;
			default:
				return COMMENT_CONTINUE;
			}
		}
	},
	// ‘/*^[*]’ 后继处理
	COMMENT_CONTINUE {
		@Override
		public State read(Character c) {
			switch (c) {
			case '*':
				return COMMENT_FIND;
			default:
				return COMMENT_CONTINUE;
			}
		}
	},
	// // ‘/**’ 后继处理
	// SECOND_ASTERISK{
	// @Override
	// public State read(Character c) {
	// switch (c) {
	// case '*':
	// return DOCUMENT_FIND;
	// case '/':
	// return END_COMMENT;
	// default:
	// return DOCUMENT_CONTINUE;
	// }
	// }
	// },
	// ‘/*（任意）*’后继处理 发现文本注释 结束星号
	COMMENT_FIND {

		@Override
		public State read(Character c) {
			switch (c) {
			case '/':
				return END_COMMENT;
			case '*':
				return COMMENT_FIND;

			default:
				return COMMENT_CONTINUE;
			}
		}

	},

	// '/**' 后继 文档注释开始
	DOCUMENT_START {
		@Override
		public State read(Character c) {
			switch (c) {
			case '*':
				return DOCUMENT_FIND;
			case '/':
				return END_COMMENT;
			default:
				return DOCUMENT_CONTINUE;
			}
		}
	},
	// ‘/**（任意）’ 后继 文档注释开始
	DOCUMENT_CONTINUE {
		@Override
		public State read(Character c) {
			switch (c) {
			case '*':
				return DOCUMENT_FIND;
			default:
				return DOCUMENT_CONTINUE;
			}
		}
	},
	// ‘/**(任意)*’后继 发现文档注释的 结束星号
	DOCUMENT_FIND {
		@Override
		public State read(Character c) {
			switch (c) {
			case '/':
				return END_DOCUMENT;
			case '*':
				return DOCUMENT_FIND;
			default:
				return DOCUMENT_CONTINUE;
			}
		}
	},

	// ‘//’形式注释结束
	END_VIRGULE {
		@Override
		public State read(Character c) {
			switch (c) {
			case '/':
				return FIND_VIRGULE;

			default:
				return READ_SKIP;
			}
		}
	},
	// ‘/** */’注释结束
	END_DOCUMENT {
		@Override
		public State read(Character c) {
			switch (c) {
			case '/':
				return FIND_VIRGULE;

			default:
				return READ_SKIP;
			}
		}
	},
	// ‘/* */’注释结束
	END_COMMENT {
		@Override
		public State read(Character c) {
			switch (c) {
			case '/':
				return FIND_VIRGULE;

			default:
				return READ_SKIP;
			}
		}
	};
	public abstract State read(Character c);
}
