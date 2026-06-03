import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";
import Sidebar from "../components/Sidebar";
import Topnav from "../components/Topnav";

function Attachments() {
    const navigate = useNavigate();
    const [notes, setNotes] = useState([]);
    const [noteId, setNoteId] = useState("");
    const [file, setFile] = useState(null);
    const [attachments, setAttachments] = useState([]);
    const [message, setMessage] = useState("");
    const [uploading, setUploading] = useState(false);
    const [loadingAttachments, setLoadingAttachments] = useState(false);

    const fetchNotes = async () => {
        try {
            const response = await api.get("/api/notes");
            setNotes(response.data);
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to load notes.");
        }
    };

    useEffect(() => { fetchNotes(); }, []);

    const handleNoteChange = async (e) => {
        const selectedNoteId = e.target.value;
        setNoteId(selectedNoteId);
        setAttachments([]);
        if (selectedNoteId) {
            setLoadingAttachments(true);
            try {
                const response = await api.get(`/api/attachments/notes/${selectedNoteId}`);
                setAttachments(response.data);
            } catch (error) {
                setMessage(error.response?.data?.message || "Failed to load attachments.");
            } finally {
                setLoadingAttachments(false);
            }
        }
    };

    const handleUploadAttachment = async (e) => {
        e.preventDefault();
        if (!noteId || !file) { setMessage("Please select a note and file."); return; }
        setUploading(true);
        try {
            const formData = new FormData();
            formData.append("file", file);
            await api.post(`/api/attachments/notes/${noteId}`, formData, { headers: { "Content-Type": "multipart/form-data" } });
            setFile(null);
            const fi = document.getElementById("attachment-file-input");
            if (fi) fi.value = "";
            setMessage("Uploaded successfully.");
            const response = await api.get(`/api/attachments/notes/${noteId}`);
            setAttachments(response.data);
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to upload.");
        } finally {
            setUploading(false);
        }
    };

    const handleDownloadAttachment = async (attachment) => {
        try {
            const response = await api.get(`/api/attachments/download/${attachment.id}`, { responseType: "blob" });
            const fileBlob = new Blob([response.data], { type: attachment.fileType || "application/octet-stream" });
            const downloadUrl = window.URL.createObjectURL(fileBlob);
            const link = document.createElement("a");
            link.href = downloadUrl;
            link.download = attachment.fileName || "attachment";
            document.body.appendChild(link);
            link.click();
            link.remove();
            window.URL.revokeObjectURL(downloadUrl);
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to download.");
        }
    };

    const handleDeleteAttachment = async (attachmentId) => {
        if (!window.confirm("Delete this attachment?")) return;
        try {
            await api.delete(`/api/attachments/${attachmentId}`);
            setMessage("Attachment deleted.");
            const response = await api.get(`/api/attachments/notes/${noteId}`);
            setAttachments(response.data);
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to delete.");
        }
    };

    const formatSize = (bytes) => {
        if (!bytes) return "—";
        if (bytes < 1024) return `${bytes} B`;
        if (bytes < 1024 * 1024) return `${(bytes / 1024).toFixed(1)} KB`;
        return `${(bytes / (1024 * 1024)).toFixed(1)} MB`;
    };

    return (
        <div className="app-layout">
            <Topnav title="Attachments" />
            <Sidebar active="attachments" />
            <main className="main-content">
                {message && <div className="dashboard-message" onClick={() => setMessage("")} style={{ cursor: "pointer" }}>{message}</div>}

                <section className="attachment-layout">
                    <div className="attachment-card">
                        <h2 style={{ fontSize: "16px", fontWeight: "500", marginBottom: "20px" }}>Upload File</h2>
                        <form onSubmit={handleUploadAttachment}>
                            <div className="form-group">
                                <label>Select Note</label>
                                <select value={noteId} onChange={handleNoteChange} required>
                                    <option value="">Choose a note...</option>
                                    {notes.map(note => (
                                        <option key={note.id} value={note.id}>{note.title}</option>
                                    ))}
                                </select>
                            </div>
                            <div className="form-group">
                                <label>Choose File</label>
                                <input id="attachment-file-input" type="file" onChange={(e) => setFile(e.target.files[0])} required />
                            </div>
                            <button type="submit" className="primary-small-btn attachment-btn" disabled={uploading}>
                                <i className="ti ti-upload" style={{ marginRight: "6px" }}></i>
                                {uploading ? "Uploading..." : "Upload File"}
                            </button>
                        </form>
                    </div>

                    <div className="attachment-card">
                        <h2 style={{ fontSize: "16px", fontWeight: "500", marginBottom: "8px" }}>Attachments</h2>
                        <p className="attachment-help">
                            {noteId ? `${attachments.length} attachment(s)` : "Select a note to view attachments"}
                        </p>

                        <div className="attachments-list">
                            {loadingAttachments ? (
                                <p style={{ color: "#5f6368", fontSize: "14px" }}>Loading...</p>
                            ) : !noteId ? (
                                <div className="empty-state" style={{ padding: "32px" }}>
                                    <i className="ti ti-paperclip" style={{ fontSize: "48px" }}></i>
                                    <p style={{ fontSize: "14px" }}>No note selected</p>
                                </div>
                            ) : attachments.length === 0 ? (
                                <div className="empty-state" style={{ padding: "32px" }}>
                                    <i className="ti ti-file-off" style={{ fontSize: "48px" }}></i>
                                    <p style={{ fontSize: "14px" }}>No attachments</p>
                                </div>
                            ) : (
                                attachments.map(attachment => (
                                    <div className="attachment-item" key={attachment.id}>
                                        <div style={{ display: "flex", alignItems: "center", gap: "12px", flex: 1 }}>
                                            <div style={{ width: "40px", height: "40px", background: "#e8f0fe", borderRadius: "8px", display: "flex", alignItems: "center", justifyContent: "center" }}>
                                                <i className="ti ti-file" style={{ fontSize: "20px", color: "#1a73e8" }}></i>
                                            </div>
                                            <div>
                                                <h3>{attachment.fileName}</h3>
                                                <p>{attachment.fileType} • {formatSize(attachment.fileSize)}</p>
                                            </div>
                                        </div>
                                        <div className="attachment-actions">
                                            <button type="button" onClick={() => handleDownloadAttachment(attachment)} title="Download">
                                                <i className="ti ti-download"></i>
                                            </button>
                                            <button type="button" className="danger-btn" onClick={() => handleDeleteAttachment(attachment.id)} title="Delete">
                                                <i className="ti ti-trash"></i>
                                            </button>
                                        </div>
                                    </div>
                                ))
                            )}
                        </div>
                    </div>
                </section>
            </main>
        </div>
    );
}

export default Attachments;
