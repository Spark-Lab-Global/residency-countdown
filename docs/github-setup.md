# 推送速查

维护者将本地仓库推到组织下的私有空仓库时可用。

**已有仓库、仅推送：**

```bash
git remote add origin https://github.com/Spark-Lab-Global/仓库名.git
git branch -M main
git push -u origin main
```

**用 GitHub CLI 在组织下新建私有库并推送（需已 `gh auth login`）：**

```bash
gh repo create Spark-Lab-Global/仓库名 --private --source=. --remote=origin --push
```

在网页上建库：<https://github.com/organizations/Spark-Lab-Global/repositories/new> → 选 **Private**，不要勾选初始化 README，避免与本地冲突。
