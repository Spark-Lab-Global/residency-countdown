# Residency 倒计时

Spark Lab 自用的**全屏 residency 周期倒计时**静态页面。在浏览器中打开主 HTML 即可使用，不依赖构建步骤或后端服务。

## 主文件

- **`S5-Residency-Countdown.html`** — 当前在用的 S5 期次（主倒计时、上海时区、Ship it 周节奏等逻辑均在此文件内，含样式与脚本）。

用本地文件方式打开，或通过任意静态资源托管提供访问。

## 归档

- **`archive/`** — 往期的 S3 等其它 HTML 副本，仅作备份与对照，不保证与当前起止或文案一致。日常请使用根目录的 S5 文件。详见 `archive/README.md`。

## 技术说明

- 单页 HTML：内联 CSS/JS，Google Fonts 通过 `https` 拉取；无法访问外网时字体会回退为系统默认，页面仍可工作。
- 主倒计时、边界闪烁、白/黑底逻辑均在脚本内，修改时间仅改 S5 内 `CONFIG` 与注释说明的 ISO/回退行即可。
- 本仓库**不含许可证文件**：为组织内部使用；对外分发时由 Spark Lab 另行决定。

## 与 GitHub 同步

在组织 [Spark-Lab-Global](https://github.com/Spark-Lab-Global) 下可建**私有**仓库，将本目录推送到远端。步骤见 **`docs/github-setup.md`**（需本机已配置 `git` / `gh` 与组织权限）。
