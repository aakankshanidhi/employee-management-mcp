# 🧑‍💼 Employee Management System with MCP Integration

A Spring Boot REST API integrated with **Model Context Protocol (MCP)**, exposing employee CRUD operations as AI-callable tools. Tested with MCP Inspector and compatible with Claude Desktop.

---

## 🚀 Features

- Full **CRUD REST API** for employee management
- **MCP Server** exposing tools for AI integration
- In-memory **H2 database** for quick setup and testing
- Tested with **MCP Inspector** and **Claude Desktop**

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Backend | Spring Boot 4.0.6 |
| AI Integration | Spring AI 2.0.0-M5 (MCP Server) |
| Database | H2 (in-memory) |
| ORM | Spring Data JPA / Hibernate |
| MCP Transport | SSE (Server-Sent Events) |


---

## 📁 Project Structure

```
employee-management/
├── src/main/java/com/mcp/employee_management/
│   ├── config/
│   │   ├── McpToolConfig.java        # MCP tool registration
│   │   └── CorsConfig.java           # CORS configuration
│   ├── controller/
│   │   └── EmployeeController.java   # REST endpoints
│   ├── entity/
│   │   └── Employee.java             # Employee entity
│   ├── mcp/
│   │   └── EmployeeMcpTools.java     # MCP tool definitions
│   ├── repository/
│   │   └── EmployeeRepository.java   # JPA repository
│   └── service/
│       └── EmployeeService.java      # Business logic
├── src/main/resources/
│   └── application.properties
└── pom.xml
```

---

## ⚙️ Setup & Running

### Prerequisites
- Java 17+
- Maven
- Node.js (for MCP Inspector / mcp-remote)

### 1. Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/employee-management-mcp.git
cd employee-management-mcp
```

### 2. Run the Spring Boot application

```bash
mvn spring-boot:run
```

App starts at `http://localhost:8080`

### 3. Access H2 Console

```
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:employee_db
Username: sa
Password: (leave empty)
```

---

## 🔌 MCP Tools Available

| Tool | Description |
|---|---|
| `add_employee` | Adds a new employee with name, email, department, salary |
| `get_all_employees` | Fetches all employees from the database |
| `update_employee` | Updates an existing employee by ID |
| `delete_employee` | Deletes an employee by ID |

---

## 🧪 Testing with MCP Inspector

```bash
npx @modelcontextprotocol/inspector
```

1. Open the URL printed in the terminal
2. Set **Transport Type** to `SSE`
3. Set **URL** to `http://localhost:8080/mcp/sse`
4. Click **Connect**
5. Go to the **Tools** tab and test each tool

---

## 🌐 REST API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/employees` | Get all employees |
| POST | `/employees` | Add a new employee |
| PUT | `/employees/{id}` | Update employee by ID |
| DELETE | `/employees/{id}` | Delete employee by ID |

---

## 🔧 MCP Server Configuration

```properties
spring.ai.mcp.server.enabled=true
spring.ai.mcp.server.name=employee-mcp
spring.ai.mcp.server.version=1.0.0
spring.ai.mcp.server.transport=SSE
spring.ai.mcp.server.sse-endpoint=/mcp/sse
spring.ai.mcp.server.sse-message-endpoint=/mcp/messages
```

### Connecting to Claude Desktop

Add this to your `claude_desktop_config.json` (`%APPDATA%\Claude\` on Windows):

```json
{
  "mcpServers": {
    "employee-mcp": {
      "command": "npx",
      "args": ["mcp-remote", "http://localhost:8080/mcp/sse"]
    }
  }
}
```

> Note: MCP in Claude Desktop requires a Pro plan.

---

## 📄 License

MIT License
