import { useNavigate } from "react-router-dom";

function Sidebar({ active }) {
    const navigate = useNavigate();

    const links = [
        { key: "notes", label: "Notes", icon: "ti-bulb", path: "/dashboard" },
        { key: "archive", label: "Archive", icon: "ti-archive", path: "/archive" },
        { key: "trash", label: "Trash", icon: "ti-trash", path: "/trash" },
        { key: "labels", label: "Labels", icon: "ti-tag", path: "/labels" },
        { key: "export", label: "Export", icon: "ti-download", path: "/export" },
        { key: "payments", label: "Payments", icon: "ti-credit-card", path: "/payments" },
        { key: "attachments", label: "Attachments", icon: "ti-paperclip", path: "/attachments" },
    ];

    return (
        <aside className="sidebar">
            {links.map(link => (
                <button
                    key={link.key}
                    type="button"
                    className={`sidebar-link ${active === link.key ? "active" : ""}`}
                    onClick={() => navigate(link.path)}
                >
                    <i className={`ti ${link.icon}`} aria-hidden="true"></i>
                    <span>{link.label}</span>
                </button>
            ))}
        </aside>
    );
}

export default Sidebar;
