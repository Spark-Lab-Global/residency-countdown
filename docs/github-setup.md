# 推送速查

本仓库标准远端：

**`https://github.com/Spark-Lab-Global/residency-countdown.git`**

已配置时可：

```bash
git push -u origin main
```

若本地尚未加 `origin`：

```bash
git remote add origin https://github.com/Spark-Lab-Global/residency-countdown.git
git branch -M main
git push -u origin main
```

在网页上新建组织仓库：<https://github.com/organizations/Spark-Lab-Global/repositories/new>（选 **Private**；若本地已有 README 等，建空库不要勾选初始文件）。

**GitHub CLI 一次性建库并推（需已 `gh auth login`）：**

```bash
gh repo create Spark-Lab-Global/residency-countdown --private --source=. --remote=origin --push
```

（若库已存在，只用上面的 `git push` 即可。）
