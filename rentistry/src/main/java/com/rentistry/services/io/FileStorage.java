package com.rentistry.services.io;

public enum FileStorage {
		AVATAR("AVATAR"), ITEM_IMAGE("ITEM_IMAGE");
		
		private String name;
		
		private FileStorage(String name){
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
}
