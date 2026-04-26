# 在 GitHub 上建立私有仓库并推送

以下假设你在本机已安装 [GitHub CLI](https://cli.github.com/)（`gh`）并已完成 `gh auth login`；也附纯网页方式说明。

## 方式 A：命令行（推荐）

在仓库根目录（含 `README.md` 与 `S5-Residency-Countdown.html` 的目录）执行：

```bash
cd "倒计时"   # 或你的项目根路径
git init
git add README.md S5-Residency-Countdown.html archive .gitignore docs
git status    # 确认
git commit -m "chore: Spark Lab residency countdown, S5 主文件与归档"
```

在组织 **Spark-Lab-Global** 下建私有空仓库，例如名称为 `residency-countdown`（名称可自改，下面用 `residency-countdown` 做示例）：

**若已用 `gh` 且账户有权访问该组织：**

```bash
gh repo create Spark-Lab-Global/residency-countdown --private --source=. --remote=origin --push
```

若已先在网页上建好了空仓库，则只加远端并推送：

```bash
git remote add origin https://github.com/Spark-Lab-Global/residency-countdown.git
git branch -M main
git push -u origin main
```

## 方式 B：仅网页

1. 在浏览器打开：<https://github.com/organizations/Spark-Lab-Global/repositories/new>（需有组织权限）。
2. **Repository name** 填写如 `residency-countdown`；**Private** 勾选。
3. 不要添加 README、.gitignore 或 License（与本地已准备的文件避免冲突）。
4. 建好后，按页面上的 “push an existing repository” 提示，在本地已 `git init` 并 `commit` 后执行所给的 `git remote add` 与 `git push`。

## 说明

- 无法远程替你执行 `gh` 或 `git push`：需在已登录的开发者机器上完成。
- 若组织开启 2FA、分支保护或只允 CI 部署，以组织策略为准。
