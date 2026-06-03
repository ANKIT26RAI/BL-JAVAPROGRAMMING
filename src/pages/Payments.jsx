import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axiosConfig";
import Sidebar from "../components/Sidebar";
import Topnav from "../components/Topnav";

function Payments() {
    const navigate = useNavigate();
    const [paymentStatus, setPaymentStatus] = useState(null);
    const [orderDetails, setOrderDetails] = useState(null);
    const [message, setMessage] = useState("");
    const [loadingStatus, setLoadingStatus] = useState(false);
    const [creatingOrder, setCreatingOrder] = useState(false);

    const fetchPaymentStatus = async () => {
        setLoadingStatus(true);
        try {
            const response = await api.get("/api/payments/status");
            setPaymentStatus(response.data);
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to load payment status.");
        } finally {
            setLoadingStatus(false);
        }
    };

    useEffect(() => { fetchPaymentStatus(); }, []);

    const handleCreateOrder = async () => {
        setMessage("");
        setOrderDetails(null);
        setCreatingOrder(true);
        try {
            const response = await api.post("/api/payments/create-order", { amount: 19900, planName: "PREMIUM_MONTHLY" });
            setOrderDetails(response.data);
            setMessage("Razorpay order created successfully.");
        } catch (error) {
            setMessage(error.response?.data?.message || "Failed to create order.");
        } finally {
            setCreatingOrder(false);
        }
    };

    return (
        <div className="app-layout">
            <Topnav title="Payments" />
            <Sidebar active="payments" />
            <main className="main-content">
                {message && <div className="dashboard-message" onClick={() => setMessage("")} style={{ cursor: "pointer" }}>{message}</div>}

                <section className="payment-layout">
                    <div className="payment-card">
                        <h2 style={{ fontSize: "18px", fontWeight: "400", marginBottom: "16px" }}>Current Plan</h2>
                        {loadingStatus ? (
                            <p style={{ color: "#5f6368" }}>Loading...</p>
                        ) : paymentStatus ? (
                            <>
                                <div className={`plan-badge ${paymentStatus.premium ? "premium-plan" : "free-plan"}`}>
                                    {paymentStatus.premium ? "⭐ PREMIUM" : "FREE"}
                                </div>
                                <div style={{ display: "grid", gap: "10px", fontSize: "14px", marginBottom: "16px" }}>
                                    <div style={{ display: "flex", justifyContent: "space-between", borderBottom: "1px solid #f1f3f4", paddingBottom: "8px" }}>
                                        <span style={{ color: "#5f6368" }}>Plan</span>
                                        <span style={{ fontWeight: "500" }}>{paymentStatus.subscriptionPlan || "FREE"}</span>
                                    </div>
                                    <div style={{ display: "flex", justifyContent: "space-between", borderBottom: "1px solid #f1f3f4", paddingBottom: "8px" }}>
                                        <span style={{ color: "#5f6368" }}>Start Date</span>
                                        <span>{paymentStatus.subscriptionStartDate || "—"}</span>
                                    </div>
                                    <div style={{ display: "flex", justifyContent: "space-between" }}>
                                        <span style={{ color: "#5f6368" }}>End Date</span>
                                        <span>{paymentStatus.subscriptionEndDate || "—"}</span>
                                    </div>
                                </div>
                                <button type="button" className="refresh-btn" onClick={fetchPaymentStatus}>
                                    <i className="ti ti-refresh" style={{ marginRight: "6px" }}></i>Refresh
                                </button>
                            </>
                        ) : (
                            <p style={{ color: "#5f6368" }}>No payment status found.</p>
                        )}
                    </div>

                    <div className="payment-card">
                        <h2 style={{ fontSize: "18px", fontWeight: "400", marginBottom: "8px" }}>Premium Plan</h2>
                        <p className="plan-price">₹199 <span style={{ fontSize: "16px", color: "#5f6368", fontWeight: "400" }}>/ month</span></p>
                        <ul className="premium-features">
                            <li>Unlimited notes</li>
                            <li>Excel export access</li>
                            <li>Advanced reminders</li>
                            <li>Premium badge</li>
                        </ul>
                        <button type="button" className="payment-btn" onClick={handleCreateOrder} disabled={creatingOrder}>
                            {creatingOrder ? "Creating..." : "Upgrade to Premium"}
                        </button>
                        <p className="payment-note">Test mode — uses Razorpay test credentials.</p>
                    </div>
                </section>

                {orderDetails && (
                    <div className="order-details-card" style={{ maxWidth: "600px", marginTop: "20px" }}>
                        <h2 style={{ fontSize: "16px", fontWeight: "500", marginBottom: "16px" }}>Order Created</h2>
                        <div className="order-grid">
                            {[
                                ["Order ID", orderDetails.orderId],
                                ["Amount", `₹${orderDetails.amount / 100}`],
                                ["Currency", orderDetails.currency],
                                ["Plan", orderDetails.planName],
                                ["Key ID", orderDetails.keyId],
                            ].map(([label, value]) => (
                                <div key={label} style={{ display: "flex", justifyContent: "space-between", borderBottom: "1px solid #f1f3f4", paddingBottom: "8px", fontSize: "14px" }}>
                                    <span style={{ color: "#5f6368" }}>{label}</span>
                                    <span style={{ fontWeight: "500", wordBreak: "break-all", maxWidth: "60%", textAlign: "right" }}>{value}</span>
                                </div>
                            ))}
                        </div>
                    </div>
                )}
            </main>
        </div>
    );
}

export default Payments;
