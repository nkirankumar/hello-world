/*
 * pojo class
 */
package my;

public class Typology {

	private String code;
	private String name;
	private String asciiCode;

	private int nodeIndex;
	private int parentIndex;

	public int getNodeIndex() {
		return nodeIndex;
	}

	public void setNodeIndex(int nodeIndex) {
		this.nodeIndex = nodeIndex;
	}

	public int getParentIndex() {
		return parentIndex;
	}

	public void setParentIndex(int parentIndex) {
		this.parentIndex = parentIndex;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAsciiCode() {
		return asciiCode;
	}

	public void setAsciiCode(String asciiCode) {
		this.asciiCode = asciiCode;
	}

	@Override
	public String toString() {
		return "Typology [code=" + code + ", name=" + name + ", asciiCode="
				+ asciiCode + ", nodeIndex=" + nodeIndex + ", parentIndex="
				+ parentIndex + "]";
	}

}
